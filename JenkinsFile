#!groovy

pipeline {
    agent any
    tools {
        maven 'M2'
        jdk 'JDK'
        nodejs 'NODEJS'
    }

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
		
		
        /*stage('Promotion') {
            steps {
                timeout(time: 2, unit: 'DAYS') {
                    input 'Do you want to Approve?'
                }
            }
        }
        stage('Deploy to Production') {
            steps {
                 //deploy using maven plugin
                 
                 // deploy only proxy and deploy both proxy and config based on edge.js update
                //bat "sh && sh deploy.sh"
                bat "mvn -f HR-API/pom.xml install -Pprod -Dusername=${apigeeUsername} -Dpassword=${apigeePassword} -Dapigee.config.options=update"
            }
        }
        stage('Integration Tests') {
            steps {
                script {
                    try {
                        // using credentials.sh to get the client_id and secret of the app..
                        // thought of using them in cucumber oauth feature
                        // bat "sh && sh credentials.sh"
                        bat "cd $WORKSPACE/test/integration && npm install"
                        bat "cd $WORKSPACE/test/integration && npm test"
                    } catch (e) {
                        //if tests fail, I have used an shell script which has 3 APIs to undeploy, delete current revision & deploy previous stable revision
                        bat "sh && sh undeploy.sh"
                        throw e
                    } finally {
                        // generate cucumber reports in both Test Pass/Fail scenario
                        bat "cd $WORKSPACE/test/integration && cp reports.json $WORKSPACE"
                        cucumber fileIncludePattern: 'reports.json'
                        build job: 'cucumber-report'
                    }
                }
            }
        }
    }

    post {
        always {
            // cucumberSlackSend channel: 'apigee-cicd', json: '$WORKSPACE/reports.json'
            sendNotifications currentBuild.result
        }
    }*/
}
