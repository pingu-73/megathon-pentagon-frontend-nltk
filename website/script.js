const parts = new URL(window.location.href);
let nme = "";
let emailid = "";
let linkedin = "";
let facebook = "";
let twitter = "";

const pathToSrc = "pentagon-megathon/frontend/website/"

function readFields() {
    inputs = document.querySelectorAll("input");
    nme = inputs[0].value;
    emailid = inputs[1].value;
    linkedin = inputs[2].value;
    facebook = inputs[3].value;
    twitter = inputs[4].value;
}

function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}

function startTest() {
    readFields();
    userRef.set({
        name: nme,
        email: emailid,
        linkedin,
        facebook,
        twitter
    });
    const absoluteRootURL = window.location.protocol + '//' + window.location.host + '/';
    console.log(absoluteRootURL + pathToSrc + "question/question.html");
    window.location = absoluteRootURL + pathToSrc + "question/question.html";
}

function initQuestions() {
    setOptionHandlers();
    getNextQuestion();
}

let askedQuestions = new Set();
const MAX_QNS = 6;

class Question {
    constructor(number, statement, image, optionStatements, optionDeltas) {
        this.number = number;
        this.statement = statement;
        this.image = image;
        this.optionStatements = optionStatements;
        this.optionDeltas = optionDeltas;
    }
}


let ocean = [0, 0, 0, 0, 0];
let currentDeltas = [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]];
const questions = [
    new Question(0, "You are late for a meeting. When you leave your house in a hurry, you…", 0, ["A. Will be right on time - your keys and wallet are right where they are supposed to be.", "B. Need a few minutes to search for your keys and wallet - they never seem to be where you put them the night before!", "C. Always have a plan B just in case things don't go well",  "D. Ask help from friends as much as possible"], [[0, 20, 0, 0, 0], [0, -20, 0, 0, 0], [15, 0, 0, 0, 0], [0, 0, 20, 0, 0]]),
    new Question(1, "Since you are finishing your work early, your boss is assigning you more work. What would you do in such situation?", 0, ["A. Raise your concerns with your boss", "B. Keep doing more work to prove yourself", "C. Agree to do work but put less effort",  "D. Throw a tantrum in office"], [[0, 0, 10, -20, 0], [10, 0, -5, 10, 0], [0, 0, -20, 0, 0], [0, -10, 0, 0, 20]]),
    new Question(2, "What do you identify first in this picture:", 0, ["A. Crocodile", "B. A Boat a kid and a father", "C. Red Circle",  "D. Random Figures"], [[0, 5, 0, 15, 0], [0, 0, 0, 0, 20], [20, 15, 0, 0, 0], [-20, 0, -15, 0, 0]]),
    new Question(3, "Which two puzzles will you will you choose first, (harder ones have more weightage)?", 0, ["A. Molecule 3-D puzzle and Metal Brainteasers", "B. Shooting star puzzle and Interlocking Bicycle", "C. Crystal Skull and Labyrinth maze",  "D. Rubik's cube  and I don't know what others are"], [[0, 20, 0, 0, 0], [20, 0, 0, 0, 0], [0, 0, 0, 0, -20], [0, 0, 0, 20, 0]]),
    new Question(4, "What time do you wake up on average for a morning shift?", 0, ["A. 4 AM to 5:30 AM", "B. 6 AM to 7:30 AM", "C. past 8 AM",  "D. 7-8 hrs after I sleep, can be anytime"], [[0, 30, 0, 0, 0], [-15, 0, 0, 0, 10], [0, -25, 0, 0, 0], [20, -35, 0, 0, -20]]),
    new Question(5, "How often do you participate in debates?", 0, ["A. Frequently, I like to hear other's opinions and discuss pros and cons", "B. Frequently, most people disagree with me and have to get into debates to get stuff done", "C. Rarely, I just don't find myself in such situations",  "D. Rarely, its just a waste of time and most debaters are passive agressive anyways"], [[30, 0, 15, 0, 20], [0, 0, 10, -20, 0], [0, 0, -10, 30, 0], [-20, 0, -20, 0, 0]])
];

function setQuestionNumber() {
    document.querySelector(".question_number").innerHTML = askedQuestions.size.toString() + ".";
}

function setOptions(opt) {
    let options = document.querySelectorAll(".option");
    for (let i = 0; i < options.length; i++) {
        options[i].innerHTML = opt[i];
    }
}

const PARAMS = 5;

function setOptionHandlers() {
    let options = document.querySelectorAll(".option");
    for (let i = 0; i < options.length; i++) {
        options[i].addEventListener("click", function(event) {
            for (let j = 0; j < PARAMS; j++) {
                ocean[j] += currentDeltas[i][j];
            }
            getNextQuestion();
        });
    }  
}

function setQuestion(question_text) {
    document.querySelector(".question_text").innerHTML = question_text;
}

const names = ["Openness", "Conscientiousness", "Extroversion", "Agreeableness", "Neuroticism"];

function showResults() {
    document.querySelector(".question_img_div").remove();
    document.querySelector(".question_container").remove();
    document.querySelector(".option_container").remove();

    // let mn = ocean[0];
    // for (let i = 0; i < 5; i++) {
    //     if (ocean[i] < mn) mn = ocean[i]; 
    // }
    
    // if (mn < 0) {
    //     for (let i = 0; i < 5; i++) {
    //         ocean[i] -= mn;
    //     }
    // }
    
    let container = document.querySelector(".container");
    let display_text = document.createElement("div");
    display_text.className = ".question_container";
    display_text.innerHTML = "Submitted, a detailed report will be emailed to you.";
    display_text.style.fontFamily = "Roboto Bold";
    display_text.style.fontSize = "3rem";
    container.appendChild(display_text);

    let oceanContainer = document.createElement("div");
    oceanContainer.style.display = "flex";
    oceanContainer.style.justifyContent = "space-evenly";
    oceanContainer.style.alignItems = "center";
    oceanContainer.style.width = "80%";
    for (let i = 0; i < 5; i++) {
        let chld = document.createElement("div");
        chld.innerHTML += names[i];
        chld.innerHTML += ": ";
        chld.innerHTML += ocean[i].toString();
        chld.style.fontSize = "2rem";
        oceanContainer.appendChild(chld);
    }    

    container.appendChild(oceanContainer);

    oceanRef.set({
        o: ocean[0],
        c: ocean[1],
        e: ocean[2],
        a: ocean[3],
        n: ocean[4]
    });
}

function getNextQuestion() {
    if (askedQuestions.size == MAX_QNS) {
        console.log("too many questions");
        showResults();
        return;
    }

    let imgDiv = document.querySelector(".question_img_div");
    if (imgDiv.childElementCount > 0) {
        let chld = document.querySelector(".q_img");
        imgDiv.removeChild(chld);
    }

    rng = getRandomInt(MAX_QNS);
    while (askedQuestions.has(rng)) {
        rng = getRandomInt(MAX_QNS);
    }

    currentDeltas = questions[rng].optionDeltas;
    askedQuestions.add(rng);
    setQuestionNumber();
    setOptions(questions[rng].optionStatements);
    setQuestion(questions[rng].statement);
    if (rng == 2 || rng == 3) {
        let imgDiv = document.querySelector(".question_img_div");
        let qimg = document.createElement("img");
        if (rng == 2) qimg.src = "../images/puzzle1.png";
        else qimg.src = "../images/puzzle2.png";
        qimg.className = "q_img";
        qimg.style.width = "50%";
        imgDiv.appendChild(qimg);
    }
}