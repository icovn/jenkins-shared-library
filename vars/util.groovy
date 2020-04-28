def getGitCommitId(Map config = [:]) {
    return sh ("git rev-parse --short HEAD").trim()
}

def getTimestamp(Map config = [:]) {
    return sh ("date +%y.%m.%d.%H%M%S").trim()
}