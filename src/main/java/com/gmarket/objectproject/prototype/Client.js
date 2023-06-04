function Lecture(name, scores) {
  this.name = name;
  this.scores = scores;
}

Lecture.prototype.stats = function () {
  return "Name: " + this.name + ", Evaluation Method: "
      + this.getEvaluationMethod();
}

Lecture.prototype.getEvaluationMethod = function (){
  return "Pass or Fail";
}
function GradeLecture(name, canceled, scores){
  Lecture.call(this, name, scores);
  this.canceled = canceled;
}

GradeLecture.prototype = new Lecture();
GradeLecture.prototype.constructor = GradeLecture;

GradeLecture.prototype.getEvaluationMethod = function (){
  return "Grade";
}
var grade_lecture = new GradeLecture("OOP", false, [1, 2, 3,]);
console.log(grade_lecture.stats())