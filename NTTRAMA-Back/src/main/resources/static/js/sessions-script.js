addDiv = document.querySelector('.addDiv');
editDiv = document.querySelector('.editDiv');

divButton = document.querySelector('.divButton');
cancelButton = document.querySelector('.cancelButton');
overlay = document.querySelector('.overlay');
confirmButton = document.querySelector('.confirmButton');
function openModal(selectedModal) {
    selectedModal.classList.remove('hide');
    overlay.classList.remove('hide');
}

divButton.addEventListener('click', function() {
    openModal(addDiv);
    document.getElementById('id').disabled = true;

});

function closeModal(selectedModal) {
    selectedModal.classList.add('hide');
    overlay.classList.add('hide');
    document.getElementById('id').value = "";

}

cancelButton.addEventListener('click', function(){
    closeModal(addDiv);
});

overlay.addEventListener('click', function(){
    closeModal(addDiv);
});

// Function to handle click event on Edit button
document.querySelectorAll('.editButton').forEach(button => {
    button.addEventListener('click', function() {
        const row = this.closest('tr');
        const sessionId = row.querySelector('.movieSessions-id').innerText;
        const projectionDate = row.querySelector('.movieSession-projection').innerText;
        const sessionStart = row.querySelector('.movieSession-start').innerText;
        const sessionEnd = row.querySelector('.movieSession-end').innerText;

        document.getElementById('id').value = sessionId;
        document.getElementById('projectionDate').value = projectionDate;
        document.getElementById('startTime').value = sessionStart;
        document.getElementById('endTime').value = sessionEnd;

        document.getElementById('id').disabled = false;

        document.querySelector('.addDiv').classList.remove('hide');
        document.querySelector('.overlay').classList.remove('hide');
    });
});



//Theme switch
function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');
    document.querySelectorAll('.form-control').forEach(input => input.classList.toggle('dark-mode'));
    document.getElementById('customer-table').classList.toggle('table-dark');
    addDiv.classList.toggle('light-mode');
}
document.getElementById('theme-toggle-btn').addEventListener('click', toggleDarkMode);