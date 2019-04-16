
const electron = require('electron');

document.getElementById('my-btn')
    .addEventListener('click', () => {
        // electron.ipcRenderer.send(
        //     'some-call',
        //     document.getElementById('my-text').value);
        // console.log('User clicked button');
        const v = document.getElementById('my-text').value;
        const div = document.getElementById('content');
        //add new HTML element to div with the my-text value
        //as it's content
        const element = document.createElement('div');
        const checkbox = document.createElement('input');
        checkbox.setAttribute('type', 'checkbox');
        element.appendChild(checkbox);
        element.appendChild(document.createTextNode( v ));
        div.appendChild(element);
        document.getElementById('my-text').value = '';
    });

