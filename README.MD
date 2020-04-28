# How to use #

## buildJavaWithSubModules
```groovy
node("java") {
    def modules = [
        'Test API'  : 'test-api',
        'Test WebService': 'test-web-service'
    ]
    buildJavaWithSubModules gitBranch: "master", gitCredentialsId: "xxx", gitUrl: "yyy", childModules: modules
}
```

# Reference #
https://www.jenkins.io/doc/pipeline/steps/
https://www.jenkins.io/doc/pipeline/examples/
https://www.jenkins.io/doc/book/pipeline/shared-libraries/
https://www.jenkins.io/blog/2017/10/02/pipeline-templates-with-shared-libraries/
https://stackoverflow.com/questions/49439413/jenkins-pipeline-iteration-on-stage-level
