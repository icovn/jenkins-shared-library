def call() {
    def response = httpRequest 'https://google.com.vn'
    return response
}
