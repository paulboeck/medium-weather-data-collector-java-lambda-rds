data "local_file" "lambda_package" {
  filename = "${path.module}/../build/distributions/${var.project}-${var.lambda-version}.zip"
}

resource "aws_lambda_function" "weather_tracker" {
  // Required arguments
  filename = data.local_file.lambda_package.filename
  function_name = var.project
  role = aws_iam_role.lambda_exec.arn
  runtime = "java17"
  handler = "org.weathertracker.Handler::handleRequest"

  // Optional arguments
  source_code_hash = "${base64sha256(data.local_file.lambda_package.filename)}"
  memory_size = 1024
  timeout = 300
}

resource "aws_cloudwatch_log_group" "lambda_log_group" {
  // Required arguments
  name = "/aws/lambda/${aws_lambda_function.weather_tracker.function_name}"

  // Optional arguments
  retention_in_days = 7
}

resource "aws_iam_role" "lambda_exec" {
  name = "serverless_lambda"

  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [{
      Action = "sts:AssumeRole"
      Effect = "Allow"
      Sid    = ""
      Principal = {
        Service = "lambda.amazonaws.com"
      }
    }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "lambda_policy" {
  role       = aws_iam_role.lambda_exec.name
  policy_arn = "arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole"
}