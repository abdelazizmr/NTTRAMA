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
    document.getElementById('firstname').value = "";
    document.getElementById('lastname').value = "";
    document.getElementById('email').value = "";
    document.getElementById('password').value = "";
    document.getElementById('passLabel').classList.remove('hide');
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
        const row = this.closest('tr'); // Get the closest row to the clicked button
        const customerId = row.querySelector('.customer-id').innerText;
        const customerEmail = row.querySelector('.customer-email').innerText;
        const customerFirstname = row.querySelector('.customer-firstname').innerText;
        const customerLastname = row.querySelector('.customer-lastname').innerText;

        document.getElementById('id').value = customerId;
        document.getElementById('firstname').value = customerFirstname;
        document.getElementById('lastname').value = customerLastname;
        document.getElementById('email').value = customerEmail;
        document.getElementById('password').required = false;
        document.getElementById('id').disabled = false;

        document.getElementById('passLabel').classList.add('hide');

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

