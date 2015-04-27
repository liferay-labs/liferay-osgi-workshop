#!/usr/local/bin/fish

curl http://localhost:8080/api/jsonws/calculator.calculator/plus \
  -u test@liferay.com:test \
  -d x=$argv[1] \
  -d y=$argv[2]
