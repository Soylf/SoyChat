document.addEventListener("DOMContentLoaded", function () {
    const chatBox = document.getElementById("chatBox");
    const messageForm = document.getElementById("messageForm");
    const messageInput = document.getElementById("messageInput");

    function fetchMessages() {
        fetch('/messages') // Получение всех сообщений
            .then(response => response.json())
            .then(messages => {
                chatBox.innerHTML = ''; // Очистка чата перед добавлением новых сообщений
                messages.forEach(message => {
                    const messageElement = document.createElement('div');
                    messageElement.textContent = message.text; // Используем поле text из MessageDto
                    chatBox.appendChild(messageElement);
                });
            })
            .catch(error => console.error('Error fetching messages:', error)); // Обработка ошибок
    }

    fetchMessages(); // Вызов функции при загрузке страницы

    messageForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const message = {
            text: messageInput.value
        };

        fetch('/messages', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        }).then(response => {
            if (response.ok) {
                messageInput.value = ''; // Очистка поля ввода
                fetchMessages(); // Обновление списка сообщений после добавления нового
            }
        }).catch(error => console.error('Error sending message:', error)); // Обработка ошибок
    });

    setInterval(fetchMessages, 3000); // Обновление сообщений каждые 3 секунды
});