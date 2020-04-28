def getGitCommitId() {
    return sh ("git rev-parse --short HEAD").trim()
}

def getTimestamp() {
    return sh ("date +%y.%m.%d.%H%M%S").trim()
}