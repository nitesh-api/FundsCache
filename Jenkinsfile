pipeline {
	agent any
	

	stages {
		
		stage('Validate OpenAPI Spec') {
			steps {
				
				sh "swagger-cli validate OpenAPI_3.json"
			
			}
		}
		stage('Generate Apigee Proxy Bundle') {
			steps {
				script {
					try {
						
						sh "openapi2apigee generateApi fundsCache -s fundsCacheDoc.json -d ."
					} catch (e) {
						throw e
					}
				}
			}
		}
		
		stage('Linting Apigee Proxy Bundles') {
			steps {
				
				sh "apigeelint -s fundsCache/apiproxy/ -f table.js"
			}
		}
}
}
