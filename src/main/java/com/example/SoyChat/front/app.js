document.addEventListener("DOMContentLoaded", function () {
    const chatBox = document.getElementById("chatBox");
    const messageForm = document.getElementById("messageForm");
    const messageInput = document.getElementById("messageInput");

    function fetchMessages() {
        fetch('/message') // Запросы на сервер отправляются на /message
            .then(response => response.json())
            .then(messages => {
                chatBox.innerHTML = '';
                messages.forEach(message => {
                    const messageElement = document.createElement('div');
                    messageElement.textContent = message.content;
                    chatBox.appendChild(messageElement);
                });
            });
    }

    fetchMessages();

    messageForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const message = {
            content: messageInput.value
        };

        fetch('/message', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        }).then(response => {
            if (response.ok) {
                messageInput.value = '';
                fetchMessages();
            }
        });
    });

    setInterval(fetchMessages, 3000);
});