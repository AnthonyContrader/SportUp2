import { LoginPage } from './login.po';
describe('Login tests', () => {
    let page: LoginPage;
    beforeEach(() => {
        page = new LoginPage();
        page.navigateTo();        
    });
    it('Login form should be valid', () => {
        page.getUsernameTextbox().sendKeys('admin');
        page.getPasswordTextbox().sendKeys('adhgf');
        
       });
});

