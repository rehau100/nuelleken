def folderName = "Nuelleken"
folder(folderName)

def myJobName = "Testjob"
def myJob = job(myJobName)

myJob.with {
    description("Eine Beschreibung")
    logRotator(10, 10)

    parameters {
        stringParam("MAIL_CONTENT", "", "Inhalt der Mail")
    }

    steps {
        shell('''echo "Shellausgabe:"
        echo MAIL_CONTENT: $MAIL_CONTENT''')
    }

    publishers {
        mailer('hausmann.rebekka@gmx.com', true, true)
    }
}