terraform {
  backend "s3" {
    bucket = "pae-terraform-state"
    key    = "terraform.tfstate"
    region = "us-east-2"
  }
}