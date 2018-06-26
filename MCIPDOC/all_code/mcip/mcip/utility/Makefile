.SUFFIXES: .java .class

.java.class:
	javac $<

SRCS = 	\
	Browser.java\
	Code.java\
	ConnectDB.java\
	ConnectionPool.java\
	DataUtility.java\
	FieldCheck.java\
	Init.java\
	InterGateway.java\
	LogWriter.java\
	ORBManager.java\
	PoolManager.java\
	SessionBuffer.java\
	SessionThread.java\
	SessionUser.java\
	Test.java\
	Tools.java


CLASSES = $(SRCS:.java=.class)

all:	$(CLASSES)

default: all

clean:
	rm -rf *.class *.~* *.bak *~
