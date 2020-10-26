# StigmaTestApp
App used with test suite to test Stigma.
- Instrument apk and run with RunStigmaTests.py on emulator/real device.
- Add more tests by leaking appropriate tainted variables via Log.d()
- Format for each Log.d test tag: "app name" "test type" "data leaked". Example: stigmatestapp sgetsput IMEI
- Allow permissions in appropriate time for testing to work.
- Test pass/fail output will show in terminal running RunStigmaTests.py

![Photo showing tests](https://i.ibb.co/DpKZp9Z/Screenshot-from-2020-10-26-05-35-32.png)
