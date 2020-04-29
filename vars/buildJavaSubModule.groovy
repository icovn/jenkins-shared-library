/**
 * Build java sub module
 * @param config Map variables: moduleName
 * @return
 */
def call(Map config=[:]) {
    error config.moduleName
    def gitCommitId = getGitCommitId()
    info gitCommitId
    def gitFilesChanges = getGitFilesChanged(gitCommitId)
    success gitFilesChanges
}

def buildDocker() {
    sh "docker login ${env.DOCKER_REPO} --username ${env.DOCKER_USERNAME} --password ${env.DOCKER_PASSWORD}"
    sh "docker build -f ${config.dockerFile} -t ${config.dockerImage} ."
    sh "docker push ${config.dockerImage}"
    sh "docker logout ${env.DOCKER_REPO}"
}

def getGitCommitId() {
    return sh ("git rev-parse --short HEAD").trim()
}

def getGitFilesChanged(commitId) {
    return sh ('git log -m -1 --name-only --pretty="format:" ' + commitId).trim()
}
