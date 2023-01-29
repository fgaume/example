// Define your secret project token here
def project_token = 'abcdefghijklmnopqrstuvwxyz0123456789ABCDEF'

// Reference the GitLab connection name from your Jenkins Global configuration (https://JENKINS_URL/configure, GitLab section)
properties([
        gitLabConnection('gitlab-9090'),
        pipelineTriggers([
                [
                        $class: 'GitLabPushTrigger',
                        branchFilterType: 'All',
                        triggerOnPush: true,
                        triggerOnMergeRequest: false,
                        triggerOpenMergeRequestOnPush: "never",
                        triggerOnNoteRequest: true,
                        noteRegex: "Jenkins please retry a build",
                        skipWorkInProgressMergeRequest: true,
                        secretToken: project_token,
                        ciSkip: false,
                        setBuildDescription: true,
                        addNoteOnMergeRequest: true,
                        addCiMessage: true,
                        addVoteOnMergeRequest: true,
                        acceptMergeRequestOnSuccess: false,
                        branchFilterType: "NameBasedFilter",
                        includeBranchesSpec: "",
                        excludeBranchesSpec: "",
                ]
        ])
])

pipeline {

    agent any

    options {

        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')

    }

    stages {

        stage('Hello java') {

            steps {

                sh '''

          java -version

        '''

            }

        }

        stage('cat README3') {

            when {

                branch "main"

            }

            steps {

                sh '''

          cat README.md

        '''

            }

        }

    }

}

