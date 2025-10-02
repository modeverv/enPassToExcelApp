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
2025-10-02T11:10:39.393058Z main ERROR Log4j API could not find a logging provider.
パスワード付きExcelを作成しました: b.xlsx
./MyApp.app/Contents/MacOS/MyApp a.xlsx b.xlsx pass  0.83s user 0.04s system 184% cpu 0.476 total
```




