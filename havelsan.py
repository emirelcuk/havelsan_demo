from flask import Flask, render_template, request, redirect, url_for
import datetime

# Task class
class Task:
    def __init__(self, title, description, due_date, priority='Medium'):
        self.title = title
        self.description = description
        self.due_date = due_date
        self.priority = priority
        self.completed = False




# Route to delete a task
@app.route('/delete/<int:task_index>')
def delete_task(task_index):
    manager.delete_task(task_index)
    return redirect(url_for('index'))

# Main entry point
if __name__ == '__main__':
    app.run(debug=True)
