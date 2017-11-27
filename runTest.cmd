@echo off
REM this script executes the Junit test
java -cp .\WebContent\WEB-INF\lib\*;.\temp\WEB-INF\classes org.junit.runner.JUnitCore com.stevenckwong.rallyintegration.TestLoginGetNameService
