import com.github.icovn.jenkins.Utilities

/**
 * Build java sub module
 * @param config Map variables: moduleName
 * @return
 */
def call(Map config=[:]) {
    def gitCommitId = Utilities.getGitCommitId(this)
    log.info("gitCommitId: ${gitCommitId}")
    def gitFilesChanges = Utilities.getGitFilesChanged(this, gitCommitId)
    log.success("gitFilesChanges: ${gitFilesChanges}")

    config.modules.each { key, val ->
        log.info("Map: $key = $val")
    }
}

def buildDocker() {
    sh "docker login ${env.DOCKER_REPO} --username ${env.DOCKER_USERNAME} --password ${env.DOCKER_PASSWORD}"
    sh "docker build -f ${config.dockerFile} -t ${config.dockerImage} ."
    sh "docker push ${config.dockerImage}"
    sh "docker logout ${env.DOCKER_REPO}"
}
