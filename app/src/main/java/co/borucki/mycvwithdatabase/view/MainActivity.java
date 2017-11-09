package co.borucki.mycvwithdatabase.view;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycvwithdatabase.LocaleHelper;
import co.borucki.mycvwithdatabase.R;
import co.borucki.mycvwithdatabase.repository.EducationRepository;
import co.borucki.mycvwithdatabase.repository.EducationRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.ExperienceBranchRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceBranchRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.ExperienceCompanyRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceCompanyRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.ExperiencePeriodRepository;
import co.borucki.mycvwithdatabase.repository.ExperiencePeriodRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.ExperienceProjectRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceProjectRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.ForeignLanguageRepository;
import co.borucki.mycvwithdatabase.repository.ForeignLanguageRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.HobbiesRepository;
import co.borucki.mycvwithdatabase.repository.HobbiesRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.PersonalDataRepository;
import co.borucki.mycvwithdatabase.repository.PersonalDataRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.SkillRepository;
import co.borucki.mycvwithdatabase.repository.SkillRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.view.fragments.ContactFragment;
import co.borucki.mycvwithdatabase.view.fragments.EducationFragment;
import co.borucki.mycvwithdatabase.view.fragments.ExperienceFragment;
import co.borucki.mycvwithdatabase.view.fragments.ForeignLanguageFragment;
import co.borucki.mycvwithdatabase.view.fragments.HobbiesFragment;
import co.borucki.mycvwithdatabase.view.fragments.SendMailFragment;
import co.borucki.mycvwithdatabase.view.fragments.SkillsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private PersonalDataRepository mRepository = PersonalDataRepositoryImpl.getInstance();
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private EducationRepository mEducationRepo = EducationRepositoryImpl.getInstance();
    private ExperienceBranchRepository mExperienceBranchRepo = ExperienceBranchRepositoryImpl.getInstance();
    private ExperienceCompanyRepository mExperienceCompanyRepo = ExperienceCompanyRepositoryImpl.getInstance();
    private ExperiencePeriodRepository mExperiencePeriodRepo = ExperiencePeriodRepositoryImpl.getInstance();
    private ExperienceProjectRepository mExperienceProjectRepo = ExperienceProjectRepositoryImpl.getInstance();
    private ForeignLanguageRepository mForeignLanguageRepo = ForeignLanguageRepositoryImpl.getInstance();
    private HobbiesRepository mHobbiesRepo = HobbiesRepositoryImpl.getInstance();
    private SkillRepository mSkillRepo = SkillRepositoryImpl.getInstance();
    @BindView(R.id.navigationToolBar)
    Toolbar navigationToolBar;
    @BindView(R.id.navigationView)
    NavigationView navigationMenu;
    @BindView(R.id.mainActivityDrawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_activity_name_and_surname)
    TextView nameAndSurname;
    @BindView(R.id.main_activity_photo)
    ImageView myPhoto;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        nameAndSurname.setText(mRepository.getName() + " " + mRepository.getSurname());
        navigationMenu.setNavigationItemSelectedListener(this);
        navigationToolBar.setTitle("Curriculum Vitae");
        navigationMenu.setCheckedItem(R.id.navigationMenuContact);
        navigationMenu.getMenu().performIdentifierAction(R.id.navigationMenuContact, 0);
        setSupportActionBar(navigationToolBar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, navigationToolBar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        View header = navigationMenu.getHeaderView(0);
        TextView navigation_view_holder_name_surname_phone =  header.findViewById(R.id.navigation_view_header_name_surname_phone);
        ImageView navigation_view_holder_image = header.findViewById(R.id.navigation_view_holder_image);
        navigation_view_holder_name_surname_phone.setText(mRepository.getName()
                + " "
                + mRepository.getSurname()
                + " "
                + mRepository.getPhone());
        Bitmap image = LocaleHelper.decodeImageFromStringToBitmap(mRepository.getPhoto());
        myPhoto.setImageBitmap(image);
        navigation_view_holder_image.setImageBitmap(image);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info_menu:
                showAlertDialogInfo();
                break;
            case R.id.info_change:
                if (mAccessPermission.getAppLanguage().equals("pl")) {
                    mAccessPermission.setAppLanguage("en");
                    LocaleHelper.setLocale(this, "en");
                    item.setIcon(R.drawable.flag_en);
                } else {
                    mAccessPermission.setAppLanguage("pl");
                    LocaleHelper.setLocale(this, "pl");
                    item.setIcon(R.drawable.flag_pl);

                }
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                finish();
                break;
            case R.id.info_reset:
                showAlertDialogReset();
                break;
            case R.id.info_refresh:
                if (LocaleHelper.isOnLine(this)) {
                    LocaleHelper.importDataInBackground();
                } else {
                    Toast.makeText(this, R.string.no_internet, Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.info_add:
                addToContactBook();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void addToContactBook() {
        Intent intentInsertEdit = new Intent(Intent.ACTION_INSERT_OR_EDIT);
        intentInsertEdit.setType(ContactsContract.Contacts.CONTENT_ITEM_TYPE);
        intentInsertEdit.putExtra(ContactsContract.Intents.Insert.NAME, mRepository.getName() + " " + mRepository.getSurname())
                .putExtra(ContactsContract.Intents.Insert.PHONE, mRepository.getPhone())
                .putExtra(ContactsContract.Intents.Insert.EMAIL, mRepository.getEmail())
                .putExtra(ContactsContract.Intents.Insert.POSTAL, mRepository.getHomeAddressStreet()
                        + " "
                        + mRepository.getHomeAddressNo()
                        + ",\n"
                        + mRepository.getHomeAddressPost()
                        + " "
                        + mRepository.getHomeAddressCity());
        startActivity(intentInsertEdit);


    }

    private void showAlertDialogInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.menu_information);
        builder.setMessage(R.string.alert_dialog_info);
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showAlertDialogReset() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_dialog_title);
        builder.setMessage(R.string.alert_dialog_reset);
        builder.setCancelable(false);
        builder.setPositiveButton(
                R.string.alert_dialog_confirm,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        deletedAllData();
                        Intent intent = new Intent(getApplication().getApplicationContext(), SplashActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplication()
                                .getApplicationContext()
                                .startActivity(intent);
                        finish();
                    }
                });
        builder.setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void deletedAllData() {
        mAccessPermission.setAccessPermission(false);
        mAccessPermission.setAccessMail(null);
        mAccessPermission.setAccessMail(null);
        mAccessPermission.setAppLanguage(null);
        mRepository.setPhone(null);
        mRepository.setName(null);
        mRepository.setSurname(null);
        mRepository.setEmail(null);
        mRepository.setGitHubProfile(null);
        mRepository.setHomeAddressGoogleLocation(null);
        mRepository.setHomeAddressCity(null);
        mRepository.setHomeAddressNo(null);
        mRepository.setHomeAddressPost(null);
        mRepository.setHomeAddressStreet(null);
        mRepository.setWebService(null);
        mRepository.setSkypeUserName(null);
        mRepository.setLinkedInProfile(null);
        mRepository.setPhoto(null);
        mRepository.setAboutPl(null);
        mRepository.setAboutEn(null);
        mEducationRepo.truncate();
        mExperienceBranchRepo.truncate();
        mExperienceCompanyRepo.truncate();
        mExperiencePeriodRepo.truncate();
        mExperienceProjectRepo.truncate();
        mForeignLanguageRepo.truncate();
        mHobbiesRepo.truncate();
        mSkillRepo.truncate();
    }

    @Override

    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item = menu.findItem(R.id.info_change);
        if (mAccessPermission.getAppLanguage().equals("en")) {
            item.setIcon(R.drawable.flag_en);
        } else {
            item.setIcon(R.drawable.flag_pl);
        }

        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(Gravity.LEFT);

        uncheckedMenuItem();
        navigationToolBar.setTitle(item.getTitle());
        item.setChecked(true);

        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigationMenuContact:
                item.setIcon(R.drawable.ic_contact_black_24dp);
                fragment = ContactFragment.newInstance();
                break;
            case R.id.navigationMenuExperience:
                fragment = ExperienceFragment.newInstance();
                break;
            case R.id.navigationMenuEducation:
                fragment = EducationFragment.newInstance();
                break;
            case R.id.navigationMenuSkills:
                fragment = SkillsFragment.newInstance();
                break;
            case R.id.navigationMenuForeignLanguages:
                fragment = ForeignLanguageFragment.newInstance();
                break;
            case R.id.navigationMenuHobby:
                fragment = HobbiesFragment.newInstance();
                break;

            case R.id.navigationMenuSendMail:
                fragment = SendMailFragment.newInstance();
                break;

        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivityContainer, fragment)
                .commit();
        return false;
    }

    private void uncheckedMenuItem() {
        for (int i = 0; i < navigationMenu.getMenu().size(); i++) {
            if (navigationMenu.getMenu().getItem(i).isChecked()) {
                navigationMenu.getMenu().getItem(i).setChecked(false);
            }
        }
    }
}
