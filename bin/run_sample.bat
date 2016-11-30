set JAVA_HOME={path to java home dir.}
set SAMPLE_HOME=ad-api-sample

set PACKAGE_NAME=jp.co.yahoo.ad_api_sample
set CLASS_PATH=%SAMPLE_HOME%\bin\ad-api-sample-SS-API-V6.2.jar;%SAMPLE_HOME%;%SAMPLE_HOME%\src\main\resources

cd %SAMPLE_HOME%
%JAVA_HOME%\bin\java -classpath %CLASS_PATH% %1
