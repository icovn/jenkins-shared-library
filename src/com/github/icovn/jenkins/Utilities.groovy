package com.github.icovn.jenkins

class Utilities implements Serializable {
    def steps
    Utilities(steps) {this.steps = steps}
    static def mvn(script, args) {
        script.sh "${script.tool 'Maven'}/bin/mvn -s ${script.env.HOME}/jenkins.xml -o ${args}"
    }
}