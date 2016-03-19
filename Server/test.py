#! /usr/bin/python
# -*- coding:utf-8 -*-
from sensor import Sensor as Se
import time
Se.setup()

while True:
    print Se.get()
    time.sleep(1)