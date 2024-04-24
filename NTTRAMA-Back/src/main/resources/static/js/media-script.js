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
    document.getElementById('video').value = "";
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
        const mediaId = row.querySelector('.media-id').innerText;
        const movieVideo = row.querySelector('.movie-video').innerText;

        document.getElementById('id').value = mediaId;
        document.getElementById('video').value = movieVideo;
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