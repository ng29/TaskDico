# TaskDico

Assignment :- Conditional  Pages with MCQ questions.

Task was to display 3 mcqs on first page and if all clicked correctly directly q 8,9,10 will be displayed else q 4,5,6,7 will be displayed.

Firstly answers of first three questions are stored in firebase.
And stringbuilder is made of id's of clicked radio buttons i.e. choosen options by user of first three questions.
Then after clicking on submit button new stringbuilder is made consisting of answers fetched from the firebase.
Both strings are compared and if all three questions are correctly chosen then desired intent is called and else other intent is called.
