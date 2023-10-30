# Complete Project Backend+Frontend
https://github.com/PraneethJain/pentagon-megathon

# Overview
Psyche-Screener is a tool that emulates an interview screening process, which has the following rounds in it

- Round 1: Using social handles
    - Pass 1: Sanity test (Perspective API)
    - Pass 2: Social media check (NLTK)
- Round 2: Personality test
    - ‘OCEAN’ mapper
    - Sitation-based Interview
    - Puzzles
    - Lifestyle Choices

Analyse candidates personality/behaviour using social media analysis, psychometric tests and challenging puzzles.

# Purpose:

We built an app, that can be used for **personality based classification** and qualification criteria for job interviews. The final results are 
calculated in a model trained with the Naïve Bayes classifier.
This app has a basic **puzzle based test**, which is used for personality classification. The output of this test is sent to the database, where 
other phases of this **virtual interview**, based on **social media analysis** is calculated.


# To Do:
- [x] App Logo
- [x] UI interface
- [x] Welcome Page, Registration Page
- [x] Push data to Realtime firebase
- [x] Questions
- [x] Score Calculation
- [x] Presentation
- [x] Email sending through GCP
- [x] Make a good requirements.txt so that it can be run by testers
- [x] Installation Documentation

# Frontend Overview:
This Project Contains a **website** and **app** for user interaction. 
Website is made using vanilla javascript. Website's **API key** needs to be changed to your firebase server's API key to collect data. For **App** you need to add **google-services.json** file to store data to firebase server
