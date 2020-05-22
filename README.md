# COVID-19 Tracker USSD/SMS application

This project demonstrates how to use Unstructured Supplementary Service Data (USSD), sometimes referred to as "Quick Codes" or "Feature codes", and Short Message Service (SMS), to track number of COVID-19 cases in Nigeria.
Harnessing the power of Machine Learning (ML), the application supports the four main Nigerian languages providing users to choice of preferred language. 

## Built With

* [SparkJava](http://sparkjava.com/) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management
* [AfricasTalking](https://africastalking.com/) - Provides USSD/SMS API
* [Firebase Database](https://console.firebase.google.com) - Used Firebase for database storage and access
* [Google Cloud Translation API](https://cloud.google.com/translate) - Google Cloud Translation service


## Features 

After dialling the USSD code, users can select a preferred language of choice while using the application. 
application
1. Latest Numbers, users can get live update on the figures of infected cases, recovery, deaths in
Nigeria
2. Protect yourself, when a user selects 2, immediately a one-time SMS is sent to the user, with
the instructions from NCDC on how to protect oneself from the virus
3. Coronavirus symptoms, users can learn about symptoms of the virus through an immediate
one-time SMS explaining the symptoms of the virus
4. Tell a friend, users can input a phone number of a relative, friend or neighbour, and
immediately a one-time SMS detailing preventive measures, is sent to the respective phone
number
5. COVID-19 symptom test, users can take a simple self-assessment test adapted from DOH
guidelines www.dog.gov.ph

## Architecture

![Project Workflow](https://github.com/SavvyProgrammer/COVID-19-USSD-SparkJava-tracker-app/blob/master/Screenshot%20from%202020-05-22%2021-55-51.png)

## Author

* **Samson Ehigiator** | **samson.o.ehigiator@gmail.com**


