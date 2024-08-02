// Добавляем обработчик события, который срабатывает, когда HTML-документ полностью загружен и обработан
document.addEventListener("DOMContentLoaded", function () {

    // Находим элемент с id "chatBox", в который будут добавляться сообщения чата
    const chatBox = document.getElementById("chatBox");

    // Находим форму с id "messageForm", которую пользователь будет использовать для отправки сообщений
    const messageForm = document.getElementById("messageForm");

    // Находим поле ввода с id "messageInput", где пользователь будет вводить текст сообщения
    const messageInput = document.getElementById("messageInput");

    // Функция для получения и отображения всех сообщений из сервера
    function fetchMessages() {
        fetch('/messages') // Посылаем запрос на сервер, чтобы получить все сообщения
            .then(response => response.json()) // Преобразуем ответ в JSON-формат
            .then(messages => { // Обрабатываем полученные сообщения
                chatBox.innerHTML = ''; // Очищаем чат перед добавлением новых сообщений
                messages.forEach(message => { // Проходим по каждому сообщению
                    const messageElement = document.createElement('div'); // Создаём новый элемент div для каждого сообщения
                    messageElement.textContent = message.text; // Заполняем элемент текстом сообщения
                    chatBox.appendChild(messageElement); // Добавляем элемент сообщения в chatBox
                });
            })
            .catch(error => console.error('Error fetching messages:', error)); // Обрабатываем ошибки при получении сообщений
    }

    // Вызываем функцию fetchMessages для получения сообщений при загрузке страницы
    fetchMessages();

    // Добавляем обработчик события submit для формы отправки сообщений
    messageForm.addEventListener("submit", function (event) {
        event.preventDefault(); // Предотвращаем перезагрузку страницы при отправке формы

        // Создаём объект message с текстом, введённым пользователем
        const message = {
            text: messageInput.value
        };

        // Отправляем новое сообщение на сервер
        fetch('/messages', {
            method: 'POST', // Указываем метод запроса POST
            headers: {
                'Content-Type': 'application/json' // Устанавливаем заголовок Content-Type для передачи JSON
            },
            body: JSON.stringify(message) // Преобразуем объект message в JSON-строку
        }).then(response => {
            if (response.ok) { // Проверяем, успешно ли прошло отправление
                messageInput.value = ''; // Очищаем поле ввода
                fetchMessages(); // Обновляем список сообщений после добавления нового
            }
        }).catch(error => console.error('Error sending message:', error)); // Обрабатываем ошибки при отправке сообщений
    });

    // Устанавливаем интервал для обновления сообщений каждые 3 секунды
    setInterval(fetchMessages, 3000);
});