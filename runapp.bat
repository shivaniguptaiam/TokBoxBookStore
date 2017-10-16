call setenv.bat
@echo off
if not exist ".\bin\com\tokbox\bookstore\BookStoreMainApp.class" (
  
  echo.
  echo Please compile application first. Run compile.bat or ant
  
) else (
  echo.
  "%JAVA_HOME%"\bin\java -cp .\bin com.tokbox.bookstore.BookStoreMainApp
)