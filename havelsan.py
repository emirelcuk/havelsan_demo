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

# Task manager class
class TaskManager:
    def __init__(self):
        self.tasks = []



    def sort_tasks(self):
        priority_order = {'High': 0, 'Medium': 1, 'Low': 2}
        self.tasks.sort(key=lambda task: (task.completed, priority_order.get(task.priority, 1), task.due_date))

    def _is_valid_index(self, index):
        return 0 <= index < len(self.tasks)


https://da58-84-51-5-150.ngrok-free.app

    try:
        due_date = datetime.datetime.strptime(due_date_str, "%Y-%m-%d").date()
        manager.add_task(title, description, due_date, priority)
    except ValueError:
        return "Invalid date format. Please use YYYY-MM-DD."

    return redirect(url_for('index'))

# Route to mark a task as complete
@app.route('/complete/<int:task_index>')
def complete_task(task_index):
    manager.complete_task(task_index)
    return redirect(url_for('index'))

# Route to delete a task
@app.route('/delete/<int:task_index>')
def delete_task(task_index):
    manager.delete_task(task_index)
    return redirect(url_for('index'))

# Main entry point
if __name__ == '__main__':
    app.run(debug=True)
