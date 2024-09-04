import datetime

# Görev sınıfı
class Task:
    def __init__(self, title, description, due_date):
        self.title = title
        self.description = description
        self.due_date = due_date
        self.completed = False

    def complete(self):
        self.completed = True

    def update(self, title=None, description=None, due_date=None):
        if title:
            self.title = title
        if description:
            self.description = description
        if due_date:
            self.due_date = due_date

    def __str__(self):
        status = "Tamamlandı" if self.completed else "Tamamlanmadı"
        return f"{self.title} | {status} | Son Tarih: {self.due_date} \nAçıklama: {self.description}"


# Görev yöneticisi sınıfı
class TaskManager:
    def __init__(self):
        self.tasks = []

    def add_task(self, title, description, due_date):
        task = Task(title, description, due_date)
        self.tasks.append(task)
        print(f"Görev '{title}' eklendi.")

    def list_tasks(self):
        if not self.tasks:
            print("Görev bulunmamaktadır.")
            return

        for index, task in enumerate(self.tasks):
            print(f"{index + 1}. {task}")

    def complete_task(self, index):
        try:
            self.tasks[index].complete()
            print(f"Görev '{self.tasks[index].title}' tamamlandı.")
        except IndexError:
            print("Geçersiz görev numarası.")

    def update_task(self, index, title=None, description=None, due_date=None):
        try:
            self.tasks[index].update(title, description, due_date)
            print(f"Görev '{self.tasks[index].title}' güncellendi.")
        except IndexError:
            print("Geçersiz görev numarası.")

    def delete_task(self, index):
        try:
            task = self.tasks.pop(index)
            print(f"Görev '{task.title}' silindi.")
        except IndexError:
            print("Geçersiz görev numarası.")


# Kullanıcı arayüzü
def main():
    manager = TaskManager()

    while True:
        print("\nGörev Takip Sistemi")
        print("1. Görev Ekle")
        print("2. Görevleri Listele")
        print("3. Görev Tamamla")
        print("4. Görev Güncelle")
        print("5. Görev Sil")
        print("6. Çıkış")
        choice = input("Bir seçenek seçin (1-6): ")

        if choice == '1':
            title = input("Görev Başlığı: ")
            description = input("Görev Açıklaması: ")
            due_date = input("Son Tarih (YYYY-MM-DD): ")
            try:
                due_date = datetime.datetime.strptime(due_date, "%Y-%m-%d").date()
                manager.add_task(title, description, due_date)
            except ValueError:
                print("Geçersiz tarih formatı. Lütfen YYYY-MM-DD formatında girin.")

        elif choice == '2':
            manager.list_tasks()

        elif choice == '3':
            manager.list_tasks()
            index = int(input("Tamamlanacak görevin numarasını girin: ")) - 1
            manager.complete_task(index)

        elif choice == '4':
            manager.list_tasks()
            index = int(input("Güncellenecek görevin numarasını girin: ")) - 1
            title = input("Yeni Görev Başlığı (boş bırakabilirsiniz): ")
            description = input("Yeni Görev Açıklaması (boş bırakabilirsiniz): ")
            due_date = input("Yeni Son Tarih (YYYY-MM-DD) (boş bırakabilirsiniz): ")
            due_date = datetime.datetime.strptime(due_date, "%Y-%m-%d").date() if due_date else None
            manager.update_task(index, title=title, description=description, due_date=due_date)

        elif choice == '5':
            manager.list_tasks()
            index = int(input("Silinecek görevin numarasını girin: ")) - 1
            manager.delete_task(index)

        elif choice == '6':
            print("Çıkılıyor...")
            break

        else:
            print("Geçersiz seçenek. Lütfen tekrar deneyin.")

# Ana programı çalıştır
if __name__ == "__main__":
    main()
