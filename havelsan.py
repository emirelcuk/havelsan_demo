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

    def complete(self):
        self.completed = True

    def update(self, title=None, description=None, due_date=None, priority=None):
        if title:
            self.title = title
        if description:
            self.description = description
        if due_date:
            self.due_date = due_date
        if priority:
            self.priority = priority

    def __str__(self):
        status = "Completed" if self.completed else "Not Completed"
        return (f"{self.title} | {status} | Priority: {self.priority} | "
                f"Due Date: {self.due_date} \nDescription: {self.description}")


# Task manager class
class TaskManager:
    def __init__(self):
        self.tasks = []

    def add_task(self, title, description, due_date, priority='Medium'):
        task = Task(title, description, due_date, priority)
        self.tasks.append(task)
        self.sort_tasks()

    def list_tasks(self):
        return self.tasks
    def  my_new_func(self):
        return self
    def complete_task(self, index):
        if self._is_valid_index(index):
            self.tasks[index].complete()

    def update_task(self, index, title=None, description=None, due_date=None, priority=None):
        if self._is_valid_index(index):
            self.tasks[index].update(title, description, due_date, priority)
            self.sort_tasks()

    def delete_task(self, index):
        if self._is_valid_index(index):
            self.tasks.pop(index)

    def sort_tasks(self):
        priority_order = {'High': 0, 'Medium': 1, 'Low': 2}
        self.tasks.sort(key=lambda task: (task.completed, priority_order.get(task.priority, 1), task.due_date))

    def _is_valid_index(self, index):
        return 0 <= index < len(self.tasks)


# Flask app setup
app = Flask(__name__)
manager = TaskManager()

# Route for the homepage
@app.route('/')
def index():
    tasks = manager.list_tasks()
    return render_template('index.html', tasks=tasks)

# Route to add a new task
@app.route('/add', methods=['POST'])
def add_task():
    title = request.form.get('title')
    description = request.form.get('description')
    due_date_str = request.form.get('due_date')
    priority = request.form.get('priority', 'Medium')

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
