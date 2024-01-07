function submitForm(event) {
    event.preventDefault();

    const formData = new FormData(document.getElementById('studentForm'));
    const jsonObject = {
        "firstName": formData.get('firstName'),
        "lastName": formData.get('lastName'),
        "graduationDate": formData.get('graduationDate')
    }

    fetch(`http://localhost:8080/api/teachers/${encodeURIComponent(formData.get('teacherId'))}/students`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(jsonObject),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Student could not be created.');
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        location.reload()
    })
    .catch(error => {
        var newDiv = document.createElement('div');
        newDiv.classList.add('uk-alert-danger');
        newDiv.setAttribute('uk-alert', '');
        newDiv.innerHTML = '<a class="uk-alert-close" uk-close></a><p>' + error + '</p>';

        document.body.insertBefore(newDiv, document.body.firstChild);
        element = document.getElementById("modal-example")
        UIkit.modal(element).hide();
    });
}