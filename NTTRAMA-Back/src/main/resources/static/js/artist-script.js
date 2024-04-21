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
    document.getElementById('firstname').value = "";
    document.getElementById('lastname').value = "";
    document.getElementById('type').value = "";
    document.getElementById('birthdate').value = "";

    document.getElementById('nationalityLabel').classList.remove('hide');
    document.getElementById('birthdateLabel').classList.remove('hide');
    document.getElementById('birthdate').disabled = false;
    document.getElementById('nationality').disabled = false;
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
        const artistId = row.querySelector('.artist-id').innerText;
        const artistFirstname = row.querySelector('.artist-firstname').innerText;
        const artistLastname = row.querySelector('.artist-lastname').innerText;
        const artistPhoto = row.querySelector('.artist-photo').innerText;

        document.getElementById('id').value = artistId;
        document.getElementById('firstname').value = artistFirstname;
        document.getElementById('lastname').value = artistLastname;
        document.getElementById('birthdate').value = artistPhoto;

        document.getElementById('birthdate').disabled = true;
        document.getElementById('nationality').disabled = true;

        document.getElementById('id').disabled = false;
        document.getElementById('nationalityLabel').classList.add('hide');
        document.getElementById('birthdateLabel').classList.add('hide');
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