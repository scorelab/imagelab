// This line is to show blocks on starting application to tell user that there are categories and blocks.
document.querySelector('#blockly-0.blocklyTreeRow').click()

/* These are the parts of guide screen */
let tour = introJs();
tour.setOptions({
    steps: [
        {
            title: 'Welcome',
            intro: '<img src="./assets/logos/Image Lab full logo.png" height="80px"> <p style="line-height=20px">Welcome to Image lab! 👋 \n Let\'s recognize our interface step by step...</p>',
        },
        {
            element: document.querySelector('.playground-pane'),
            title: 'Playground',
            intro: 'This workspace allows you to utilize blocks to perform the desired operations on your picture. Feel free to use (Ctrl+F) to quickly locate a specific block.',
            position: 'right',
        },
        {
            element: document.querySelector('#blockly-0.blocklyTreeRow'),
            title: 'Category',
            intro: 'On clicking any category, a bunch of blocks of operations related to this category appears. \n Then, you can drag blocks and drop it into workspace.',
            position: 'left',
            disableInteraction: false,
        },
        {
            element: document.querySelector('.preview-pane'),
            title: 'Preview area',
            intro: 'This is the area where your processed image is shown',
            position: 'bottom',
        },
        {
            element: document.querySelector('.properties-pane'),
            title: 'Properties area',
            intro: 'Here, you have the ability to customize the properties of the selected operation block.',
            position: 'top',
        },
        {
            element: document.querySelector('.information-pane'),
            title: 'Block definition',
            intro: 'This part shows a brief about the operation of the block you choose.',
            position: 'top',
        },
        {
            title: 'Enjoy!',
            intro: 'Let\'s do great things!',
        },
    ],
});

tour.start();
