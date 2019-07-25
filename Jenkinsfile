pipeline {
	agent any
	

	stages {
		
		stage('Validate OpenAPI Spec') {
			steps {
				sh "npm install -g swagger-cli"
				sh "swagger-cli validate OpenAPI_3.json"
				sh "npm install -g apigeelint"
				sh "apigeelint -s HR-API/apiproxy/ -f codeframe.js"
			}
		}
		stage('Generate Apigee Proxy Bundle') {
			steps {
				script {
					try {
						sh "npm install -g openapi2apigee"
						sh "openapi2apigee generateApi fundsCache -s fundsCacheDoc.json -d ."
					} catch (e) {
						throw e
					}
				}
			}
		}
		
		stage('Linting Apigee Proxy Bundles') {
			steps {
				sh "npm install -g apigeelint"
				sh "apigeelint -s fundsCache/apiproxy/ -f table.js"
			}
		}
}
}
