package com.github.icovn.jenkins

class Utilities implements Serializable {
    def steps
    Utilities(steps) {this.steps = steps}
    static def mvn(script, args) {
        script.sh "${script.tool 'Maven'}/bin/mvn -s ${script.env.HOME}/jenkins.xml -o ${args}"
    }

    static def getGitCommitId() {
        return sh ("git rev-parse --short HEAD").trim()
    }

    static def getGitFilesChanged(commitId) {
        println("commitId: ${commitId}")
        def command = "git log -m -1 --name-only --pretty=\"format:\" ${commitId}"
        println("command: ${command}")
        return sh (command).trim()
    }
}