import datetime

# Görev sınıfı
class Task:
    def __init__(self, title, description, due_date, priority='Orta'):
        self.title = title
        self.description = description
        self.due_date = due_date
        self.priority = priority
        self.completed = False

    def complete(self):
        self.completed = True


    def __str__(self):
        status = "Tamamlandı" if self.completed else "Tamamlanmadı"
        return f"{self.title} | {status} | Öncelik: {self.priority} | Son Tarih: {self.due_date} \nAçıklama: {self.description}"


# Görev yöneticisi sınıfı
class TaskManager:
    def __init__(self):
        self.tasks = []

    def add_task(self, title, description, due_date, priority='Orta'):
        task = Task(title, description, due_date, priority)
        self.tasks.append(task)
        self.sort_tasks()
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

    def update_task(self, index, title=None, description=None, due_date=None, priority=None):
        try:
            self.tasks[index].update(title, description, due_date, priority)
            self.sort_tasks()
            print(f"Görev '{self.tasks[index].title}' güncellendi.")
        except IndexError:
            print("Geçersiz görev numarası.")

    def delete_task(self, index):
        try:
            task = self.tasks.pop(index)
            print(f"Görev '{task.title}' silindi.")
        except IndexError:
            print("Geçersiz görev numarası.")

    def sort_tasks(self):
        # Görevleri önceliğe göre sıralar: Yüksek > Orta > Düşük
        priority_order = {'Yüksek': 0, 'Orta': 1, 'Düşük': 2}
        self.tasks.sort(key=lambda task: priority_order.get(task.priority, 1))

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
            priority = input("Öncelik (Düşük, Orta, Yüksek): ").capitalize()
            if priority not in ['Düşük', 'Orta', 'Yüksek']:
                print("Geçersiz öncelik. Varsayılan olarak 'Orta' seçildi.")
                priority = 'Orta'

            try:
                due_date = datetime.datetime.strptime(due_date, "%Y-%m-%d").date()
                manager.add_task(title, description, due_date, priority)
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
            priority = input("Yeni Öncelik (Düşük, Orta, Yüksek) (boş bırakabilirsiniz): ").capitalize()
            if due_date:
                try:
                    due_date = datetime.datetime.strptime(due_date, "%Y-%m-%d").date()
                except ValueError:
                    print("Geçersiz tarih formatı. Varsayılan olarak mevcut tarih korunacak.")
                    due_date = None

            manager.update_task(index, title=title, description=description, due_date=due_date, priority=priority)

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
