# set password to excel via POI

single application to set password to xlsx file with no jre install.

## build

```bash
./gradlew jpackage --stacktrace
```

if you are on windows, you modify build.gradle's output format to exe

## run and performance

at m1pro mac,
```bash
time ./MyApp.app/Contents/MacOS/MyApp a.xlsx b.xlsx pass
パスワード付きExcelを作成しました: b.xlsx
./MyApp.app/Contents/MacOS/MyApp a.xlsx b.xlsx pass  0.92s user 0.07s system 178% cpu 0.554 total
```




