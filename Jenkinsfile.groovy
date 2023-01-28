node{
    cleanWs()
    try{
        stage('PremiereEtape'){
            sh "echo 'Hello World 1 !!'"
        }
        stage('DeuxiemeEtape'){
            sh "echo 'Hello World 2 !!'"
        }
    }
    finally{
        cleanWs()
    }
}
