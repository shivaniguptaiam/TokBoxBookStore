source ./setenv.sh

echo "";
if [ ! -f ./bin/com/tokbox/bookstore/BookStoreMainApp.class ] 
then
    echo "Please compile application first. Run compile.sh or ant";
else
    "${JAVA_HOME}"/bin/java -cp ./bin com.tokbox.bookstore.BookStoreMainApp
fi;
