pipeline {
	agent any
	

	stages {
		
		stage('Validate OpenAPI Spec') {
			steps {
				sh "export PATH=$PATH:/usr/local/bin/npm"
				sh "npm install -g swagger-cli"
				sh "swagger-cli validate OpenAPI_3.json"
			
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
