from flask import Flask,jsonify
app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/sound')
def sound():
    return jsonify(id=1)

if __name__ == '__main__':
    app.run(host="0.0.0.0",port=8080)