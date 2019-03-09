#!/usr/bin/env bash
sudo socat -v -d -d pty,raw,echo=0 pty,raw,echo=0,link=/dev/tty.usbmodem
#sudo chmod a+rw /dev/ttys007