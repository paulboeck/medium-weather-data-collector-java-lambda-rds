resource "aws_secretsmanager_secret" "example" {
  name                    = "weather-tracker-rds-password"
  recovery_window_in_days = 0 // Overriding the default recovery window of 30 days
}

resource "aws_secretsmanager_secret_version" "example" {
  secret_id     = aws_secretsmanager_secret.example.id
  secret_string = var.db-password
}