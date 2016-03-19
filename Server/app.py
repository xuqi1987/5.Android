#! /usr/bin/python
# -*- coding:utf-8 -*-


from flask import Flask,jsonify
from sensor import Sensor as Se

app = Flask(__name__)

@app.route('/sound')
def sound():
    Se.setup()
    return jsonify(id=Se.get())

    pass
if __name__ == '__main__':
    app.run(host="0.0.0.0",port=8080)