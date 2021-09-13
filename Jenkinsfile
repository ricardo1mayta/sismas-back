pipeline {
    agent any
    options {
        ansiColor('xterm')
        skipDefaultCheckout true
    }
    stages {
        stage('Checkout') {
          steps {
            checkout scm
          }
        }
        stage('Build App / Construccion de la Aplicacion') {
            steps {
//./deploy/mvn.sh mvn clean compile install 0 cd ./app  && mvn clean compile install
//                        cd ./app
//mvn clean compile install
                sh '''
                        cd ./app  && mvn clean compile install
                   '''   
            }
        }
        stage('Deploy App / Despliegue de la aplicacion') {
            steps {
				sh 'chmod -R 777 ./*'
                sh './deploy/codedeploy.sh'
                sh 'echo reinicio de servicio docker-compose'
            }
        }
    }
}
